package cvut.rsp.graphql.input;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PreferenceInput
{
    private List<Long> musicals;

    private List<Long> actors;

    private boolean withChildren;

    public List<Long> getMusicals() { return musicals; }
    public void setMusicals(List<Long> musicals) { this.musicals = musicals; }
    public List<Long> getActors() {return actors; }
    public void setActors(List<Long> actors) {this.actors = actors; }
    public boolean isWithChildren() { return withChildren; }
    public void setWithChildren(boolean withChildren) { this.withChildren = withChildren; }
}
