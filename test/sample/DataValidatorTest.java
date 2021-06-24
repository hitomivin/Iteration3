package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {

    @Test
    void isValidCPRNul() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRKort() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("12345");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRLang() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("151096202120");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRNoBindestreg() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("1510960221");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRMedBogstave() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("151096-qqxx");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRMedForkertFormat1() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("961015-0234");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRMedSlash() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("151096/2021");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRMedForkertFormat2() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("0234-151096");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRMedForkertFormat3() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("98-0623-1256");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRMedForkertFormat4() {
        boolean expectedResult = false;
        boolean actualResult = DataValidator.isValidCPR("20-01-76-4567");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

    @Test
    void isValidCPRKorrekt() {
        boolean expectedResult = true;
        boolean actualResult = DataValidator.isValidCPR("151096-2021");

        assertEquals(expectedResult, actualResult, "it's not correct CPR");
    }

}