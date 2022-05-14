package cvut.rsp.service;

import cvut.rsp.api.service.IFilterService;
import cvut.rsp.dao.entity.Musical;
import cvut.rsp.api.repository.IMusicalRepository;
import cvut.rsp.graphql.input.PreferenceInput;
import cvut.rsp.graphql.input.SortInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class FilterService implements IFilterService
{
    @Autowired IMusicalRepository iMusicalRepository;

    @Override public List<Musical> filterRandom(Integer limit)
    {
        var ids = iMusicalRepository.getAllIds();

        if(ids.size() < limit) { return  iMusicalRepository.findAllById(ids); }

        var set = new HashSet<Long>();

        while(set.size() < limit)
        {
            var rand = ThreadLocalRandom.current().nextInt(ids.size());

            set.add(ids.get(rand));
        }
        
        return iMusicalRepository.findAllById(set);
    }

    //TODO: Implement filtering algorithm

    @Override public List<Musical> filter(PreferenceInput preference)
    {
        List<Musical> musicals = new ArrayList<>();

        //musicalIds from preference
        List<Long> musicalsIds = new ArrayList<>(preference.getMusicals());

        //get musical ids by actors
        preference.getActors().forEach(a -> musicalsIds.addAll(iMusicalRepository.getMusicalsIdsByActorId(a)));

        List<Long> musicalsIdsWithChildren = new ArrayList<>();

        //filter by argument withChildren
        musicalsIds.forEach(m -> {
            Long tmp_musical = iMusicalRepository.getMusicalIdWithChildren(preference.isWithChildren(), m);
            if (tmp_musical != null){
                musicalsIdsWithChildren.add(tmp_musical);
            }
        });

        List<Long> sortedMusicals = new ArrayList<>();

        //sort by number of occurrences
        for (int i = 0; i < musicalsIdsWithChildren.size(); i++) {
            if(Collections.frequency(musicalsIdsWithChildren, musicalsIdsWithChildren.get(i)) > 1){
                sortedMusicals.add(0, musicalsIdsWithChildren.get(i));
            }else{
                sortedMusicals.add(musicalsIdsWithChildren.get(i));
            }
        }
        //remove duplicates
        sortedMusicals = sortedMusicals.stream().distinct().collect(Collectors.toList());

        //add to final array
        sortedMusicals.forEach(e -> iMusicalRepository.findById(e).ifPresent(musicals::add));

        return musicals;
    }

    @Override public Musical filter(Long id) { return iMusicalRepository.findById(id).get(); }

    @Override public List<Musical> sortMusicalsByPrice(SortInput sortInput){
        List<Musical> musicals = new ArrayList<>();

        List<Long> musicalsList = sortInput.getMusicals();
        musicalsList = musicalsList.stream().distinct().collect(Collectors.toList());
        List<Integer> pricesList = new ArrayList<>();
        Map<Integer, Long> musicalIdPrice = new HashMap<>();

        if (sortInput.isAscending()){
            for (Long musicalId : musicalsList){
                List<Integer> prices = iMusicalRepository.getMusicalPrices(musicalId);
                int price = Collections.min(prices);
                pricesList.add(price);
                musicalIdPrice.put(price, musicalId);
            }
        }else{
            for (Long musicalId : musicalsList){
                List<Integer> prices = iMusicalRepository.getMusicalPrices(musicalId);
                int price = Collections.max(prices);
                pricesList.add(price);
                musicalIdPrice.put(price, musicalId);
            }
        }
        //sort by price
        Collections.sort(pricesList);
        if (!sortInput.isAscending()){
            Collections.reverse(pricesList);
        }

        List<Long> musicalIds = new ArrayList<>();

        for (Integer price : pricesList){
            musicalIds.add(musicalIdPrice.get(price));
        }

        musicalIds.forEach(e -> iMusicalRepository.findById(e).ifPresent(musicals::add));

        return musicals;
    }

    @Override public List<Musical> sortMusicalsByDate(SortInput sortInput){
        List<Musical> musicals = new ArrayList<>();

        List<Long> musicalsList = sortInput.getMusicals();
        musicalsList = musicalsList.stream().distinct().collect(Collectors.toList());
        List<LocalDate> datesList = new ArrayList<>();
        Map<LocalDate, Long> musicalIdDate = new HashMap<>();

        if (sortInput.isAscending()){
            for (Long musicalId : musicalsList){
                List<String> datesAsString = iMusicalRepository.getMusicalDates(musicalId);
                List<LocalDate> dates = new ArrayList<>();
                datesAsString.forEach(d -> dates.add(LocalDate.parse(d)));

                LocalDate nearestDate = dates.get(0);
                for(LocalDate date : dates){
                    if (date.getYear() < nearestDate.getYear()){
                        nearestDate = date;
                    }else if(date.getYear() == nearestDate.getYear()){
                        if (date.getMonthValue() < nearestDate.getMonthValue()){
                            nearestDate = date;
                        }else if(date.getMonthValue() == nearestDate.getMonthValue()){
                            if (date.getDayOfMonth() < date.getDayOfMonth()){
                                nearestDate = date;
                            }
                        }
                    }
                }
                datesList.add(nearestDate);
                musicalIdDate.put(nearestDate, musicalId);
            }
        }else{
            for (Long musicalId : musicalsList){
                List<String> datesAsString = iMusicalRepository.getMusicalDates(musicalId);
                List<LocalDate> dates = new ArrayList<>();
                datesAsString.forEach(d -> dates.add(LocalDate.parse(d)));

                LocalDate furthestDate = dates.get(0);
                for(LocalDate date : dates){
                    if (date.getYear() > furthestDate.getYear()){
                        furthestDate = date;
                    }else if(date.getYear() == furthestDate.getYear()){
                        if (date.getMonthValue() > furthestDate.getMonthValue()){
                            furthestDate = date;
                        }else if(date.getMonthValue() == furthestDate.getMonthValue()){
                            if (date.getDayOfMonth() > date.getDayOfMonth()){
                                furthestDate = date;
                            }
                        }
                    }
                }
                datesList.add(furthestDate);
                musicalIdDate.put(furthestDate, musicalId);
            }
        }

        Collections.sort(datesList);
        if (!sortInput.isAscending()){
            Collections.reverse(datesList);
        }

        List<Long> musicalIds = new ArrayList<>();

        for (LocalDate date : datesList){
            musicalIds.add(musicalIdDate.get(date));
        }

        musicalIds.forEach(e -> iMusicalRepository.findById(e).ifPresent(musicals::add));

        return musicals;
    }
}
