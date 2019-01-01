package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {
    String string = "1,0" +
            "\n" +
            "N" +
            "\n" +
            "5" +
            "\n" +
            "3,0;1,3;4,3;1,4" +
            "\n" +
            "4,1" +
            "\n" +
            "RRFLFRFF";
    @Test
    void testParseActions(){
        InputParser parser = new InputParser();
        char[] result = parser.parseActions(string);
        char[] expected = {'R','R','F','L','F','R','F','F'};
        assertArrayEquals(expected, result, "Action array should be like this");
    }

    @Test
    void testParseRover(){
       InputParser parser = new InputParser();
       Rover result = parser.parseRover(string);
       Rover expected = new Rover(Direction.NORTH, new Position(1,0));
       assertEquals(expected, result, "Rover should be like this");
    }
    @Test
    void testParseLandscape(){
        InputParser parser = new InputParser();
        Landscape result = parser.parseLandscape(string);
        String expected = ".....\n...00\n.....\n0....\n...0.\n";
        assertEquals(expected, result.toString(), "Landscape should look like this");
    }
}