package statistics;

import statistics.Player;
import statistics.matcher.AllMatcher;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        matcher = new AllMatcher();
    }
    
   
    public Matcher build() {
        Matcher matcherHelp = matcher;
        matcher = new AllMatcher();
        return matcherHelp;
    }

    QueryBuilder playsIn(String team) {
        this.matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }

    QueryBuilder and(Matcher... matchers) {
        this.matcher = new And(this.matcher, new And(matchers));
        return this;
    }

    QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(this.matcher, new HasAtLeast(value, category));
        return this;
    }

   QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(this.matcher, new HasFewerThan(value, category));
        return this;
    }

    QueryBuilder not(Matcher... matchers) {
        this.matcher = new And(this.matcher, new Not(matchers));
        return this;
    }

    QueryBuilder or(Matcher... matchers) {
        this.matcher = new And(this.matcher, new Or(matchers));
        return this;
    }
    
    QueryBuilder oneOf(Matcher matcher1, Matcher matcher2) {
        this.matcher = new Or(matcher1, matcher2);
        return this;
        
    }



}
