package cvut.rsp.graphql.input;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortInput {

    private List<Long> musicals;
    private boolean ascending;

    public List<Long> getMusicals() { return musicals; }
    public void setMusicals(List<Long> musicals) { this.musicals = musicals; }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
