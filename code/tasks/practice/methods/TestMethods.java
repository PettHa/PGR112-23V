package tasks.practice.methods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tasks.practice.methods.src.Methods;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethods
{
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private Methods methods = new Methods();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(this.output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(this.stdout);
    }

    @Test
    @DisplayName("addTwoNumbers: Legge sammen 2 ulike tall gitt som parametere")
    public void testAddTwoNumbers() {
        assertEquals(3, methods.addTwoNumbers(1, 2));
    }

    @Test
    @DisplayName("addNumbersInArrayList: Legg sammen alle tallene fra en ArrayList")
    public void testAddNumbersInArrayList() {
        ArrayList<Integer> numbers = new ArrayList<>(5);

        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(8);
        numbers.add(16);

        assertEquals(31, methods.addNumbersInArrayList(numbers));
    }

    @Test
    @DisplayName("isNumberSmallMediumOrBig: Returner riktig tekst verdi utifra tallverdien gitt")
    public void testIsNumberSmallMediumOrBig() {
        assertEquals("small", methods.isNumberSmallMediumOrBig(99).toLowerCase());
        assertEquals("medium", methods.isNumberSmallMediumOrBig(100).toLowerCase());
        assertEquals("medium", methods.isNumberSmallMediumOrBig(1000).toLowerCase());
        assertEquals("big", methods.isNumberSmallMediumOrBig(1001).toLowerCase());
    }

    @Test
    @DisplayName("printStringParameter: Print ut et parameter gitt av typen String til terminalen")
    public void testPrintStringParameter() {
        String text = "Programmering tar tid å mestre";

        methods.printStringParameter(text);

        assertEquals(text, this.output.toString().trim());
    }

    @Test
    @DisplayName("printStringsFromArrayList: printe ut alle tekst-verdiene fra et ArrayList til terminalen")
    public void testPrintStringsFromArrayList() {
        ArrayList<String> lines = new ArrayList<>(5);

        lines.add("Programmering");
        lines.add("tar");
        lines.add("tid");
        lines.add("å");
        lines.add("mestre");

        methods.printStringsFromArrayList(lines);

        assertEquals("Programmeringtartidåmestre", this.output.toString().replaceAll("\\p{Cntrl}", ""));
    }

    @Test
    @DisplayName("printCourseName: Print ut navnet til et emne gitt en emnekode")
    public void testPrintCourseName() {
        methods.printCourseName("PGR112");
        assertEquals("Objektorientert programmering", this.output.toString().trim());

        methods.printCourseName("TK2100");
        assertEquals("Informasjonssikkerhet", this.output.toString().trim());

        methods.printCourseName("PGR110");
        assertEquals("Visual Analytics", this.output.toString().trim());
    }

    @Test
    @DisplayName("isColorInNorwegianFlag: Returnere om en farge gitt er en del av det norske flagget eller ikke")
    public void testIsColorInNorwegianFlag() {
        assertTrue(methods.isColorInNorwegianFlag("red"));
        assertTrue(methods.isColorInNorwegianFlag("white"));
        assertTrue(methods.isColorInNorwegianFlag("blue"));

        assertFalse(methods.isColorInNorwegianFlag("purple"));
        assertFalse(methods.isColorInNorwegianFlag("green"));
    }

    @Test
    @DisplayName("firstOccurendeOfLetter: Returnere posisjonen til første forekomst av en karakter")
    public void testFirstOccurenceOfLetter() {
        assertEquals(1, methods.firstOccurenceOfLetter("red", 'e'));
        assertEquals(-1, methods.firstOccurenceOfLetter("red", 'b'));
        assertEquals(2, methods.firstOccurenceOfLetter("PGR112", 'R'));
    }

    @Test
    @DisplayName("combinedLength: Legge sammen lengden på 2 String-verdier")
    public void testCombinedLength() {
        assertEquals(7, methods.combinedLength("red", "blue"));
    }

    @Test
    @DisplayName("addNumbers: Legge sammen tall i en liste gitt med variabel lengde")
    public void testAddNumbers() {
        assertEquals(15, methods.addNumbers(1, 2, 4, 8));
        assertEquals(63, methods.addNumbers(1, 2, 4, 8, 16, 32));
        assertEquals(6, methods.addNumbers(1, 2, 3));
    }
}