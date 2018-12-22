package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void testParseActions(){
    String string = "1,0" +
            "\n" +
            "N" +
            "\n" +
            "5" +
            "\n" +
            "2,0;1,3;4,3;1,5;" +
            "\n" +
            "4,0" +
            "\n" +
            "RRFLFRFF";
    System.out.println(string);
    InputParser parser = new InputParser();
    char[] result = parser.parseActions(string);
    char[] expected = {'R','R','F','L','F','R','F','F'};
    assertEquals(expected, result, "Action array should be like this");
    }

    @Test
    void testParseRover(){

    }
    @Test
    void testParseLandscape(){

    }
}