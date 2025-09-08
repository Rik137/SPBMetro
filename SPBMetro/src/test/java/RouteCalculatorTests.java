import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.*;

public class RouteCalculatorTests extends TestCase {
    RouteCalculator routeCalculator;
    StationIndex stationIndex;


    @Override
    protected void setUp() throws Exception {

        Line line1 = new Line(1, "первая");
        Line line2 = new Line(2, "вторая");
        Line line3 = new Line(3, "третья");

        Station station1_1 = new Station("ораньжевая", line1);
        Station station1_2 = new Station("зеленая", line1);
        Station station1_3 = new Station("пурпурная", line1);
        Station station1_4 = new Station("октяборьская", line1);


        Station station2_1 = new Station("киевская", line2);
        Station station2_2 = new Station("желтая", line2);
        Station station2_3 = new Station("вднх", line2);
        Station station2_4 = new Station("свиблово", line2);

        Station station3_1 = new Station("светлая", line3);
        Station station3_2 = new Station("никольская", line3);
        Station station3_3 = new Station("саратовская", line3);
        Station station3_4 = new Station("багрянка", line2);



        stationIndex = new StationIndex();

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);


        stationIndex.addStation(station1_1);
        stationIndex.addStation(station1_2);
        stationIndex.addStation(station1_3);
        stationIndex.addStation(station1_4);
        stationIndex.addStation(station2_1);
        stationIndex.addStation(station2_2);
        stationIndex.addStation(station2_3);
        stationIndex.addStation(station2_4);
        stationIndex.addStation(station3_1);
        stationIndex.addStation(station3_2);
        stationIndex.addStation(station3_3);
        stationIndex.addStation(station3_4);

        line1.addStation(station1_1);
        line1.addStation(station1_2);
        line1.addStation(station1_3);
        line1.addStation(station1_4);
        line2.addStation(station2_1);
        line2.addStation(station2_2);
        line2.addStation(station2_3);
        line2.addStation(station2_4);
        line3.addStation(station3_1);
        line3.addStation(station3_2);
        line3.addStation(station3_3);
        line3.addStation(station3_4);

        List<Station> connectionStations = new ArrayList<>();
        List<Station> connectionStations1 = new ArrayList<>();
        connectionStations.add(station1_2);
        connectionStations.add(station2_1);
        connectionStations1.add(station2_3);
        connectionStations1.add(station3_2);

        stationIndex.addConnection(connectionStations);
        stationIndex.addConnection(connectionStations1);

        routeCalculator = new RouteCalculator(stationIndex);
    }

    public void testGetShortestRoute(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("ораньжевая", 1),
                stationIndex.getStation("октяборьская", 1));
        List<Station> expected = List.of(stationIndex.getStation("ораньжевая", 1),
                stationIndex.getStation("зеленая", 1), stationIndex.getStation("пурпурная", 1),
                stationIndex.getStation("октяборьская", 1));
        assertEquals(expected, actual);
    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(routeCalculator.
                getShortestRoute(stationIndex.getStation("ораньжевая", 1),
                        stationIndex.getStation("октяборьская", 1)));
        double expected = 7.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("ораньжевая", 1),
                stationIndex.getStation("желтая", 2));
        List<Station> expected = List.of(stationIndex.getStation("ораньжевая", 1),
                stationIndex.getStation("зеленая", 1), stationIndex.getStation("киевская", 2),
                stationIndex.getStation("желтая", 2));
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("ораньжевая", 1),
                stationIndex.getStation("саратовская", 3));
        List<Station> expected = List.of(stationIndex.getStation("ораньжевая", 1),
                stationIndex.getStation("зеленая", 1), stationIndex.getStation("киевская", 2),
                stationIndex.getStation("желтая", 2), stationIndex.getStation("вднх", 2),
                stationIndex.getStation("никольская", 3),
                stationIndex.getStation("саратовская", 3));
        assertEquals(expected, actual);

    }

    public void testCalculateDurationOneConnection(){
        double actual = RouteCalculator.calculateDuration(routeCalculator.
                getShortestRoute(stationIndex.getStation("ораньжевая", 1),
                        stationIndex.getStation("желтая", 2)));
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationTwoConnection(){
        double actual = RouteCalculator.calculateDuration(routeCalculator.
                getShortestRoute(stationIndex.getStation("ораньжевая", 1),
                        stationIndex.getStation("саратовская", 3)));
        double expected = 17;
        assertEquals(expected, actual);
    }

}