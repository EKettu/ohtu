package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        //     Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstatistics.herokuapp.com/players.txt"));
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        QueryBuilder query = new QueryBuilder();

//    Matcher m2 = query.hasFewerThan(10, "goals").build();
//  
//    Matcher m = query.playsIn("PHI")
//                     .hasFewerThan(10, "goals")
//                     .hasFewerThan(10, "assists").build();
//   Matcher m3 = query.playsIn("PHI").hasFewerThan(15, "goals").build();
//   
//   Matcher m4 = query.playsIn("NYR").build();
        Matcher m5 = query.oneOf(
                query.playsIn("PHI")
                        .hasAtLeast(10, "goals")
                        .hasFewerThan(20, "assists").build(),
                query.playsIn("EDM")
                        .build()
        ).build();

        System.out.println("");
        for (Player player : stats.matches(m5)) {
            System.out.println(player);
        }
//        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
//
//        Matcher m = new And(new HasAtLeast(10, "goals"),
//                new HasAtLeast(10, "assists"),
//                new PlaysIn("PHI")
//        );
//
//        Matcher m2 = new Or(new HasAtLeast(5, "goals"),
//                new HasAtLeast(15, "assists"),
//                new PlaysIn("PHI")
//        );
//
//        Matcher m3 = new Not(new HasAtLeast(10, "goals"),
//                new HasAtLeast(15, "assists"),
//                new PlaysIn("PHI")
//        );
//
//        Matcher m4 = new And(new HasFewerThan(10, "goals"),
//                new HasFewerThan(15, "assists"),
//                new PlaysIn("PHI")
//        );
//
//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }
//
////        System.out.println("OR alkaa tästä");
////        for (Player player : stats.matches(m2)) {
////            System.out.println(player);
////        }
////        System.out.println("NOT alkaa tästä");
////        for (Player player : stats.matches(m3)) {
////            System.out.println(player);
////        }
//        
//        System.out.println("HasFewerThan tässä");
//                for (Player player : stats.matches(m4)) {
//            System.out.println(player);
//        }
//        

    }
}
