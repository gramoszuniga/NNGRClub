/*  
    Document   : NNGRMemberTest
    Created on : Apr 03, 2016, 2:57:00 PM
    Author     : Navjot Nagi & Gonzalo Ramos Zúñiga
 */
package club.business;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Navjot Nagi & Gonzalo Ramos Zúñiga
 */
public class NNGRMemberTest {

    public NNGRMemberTest() {

    }

    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Member member = new Member();
        member.setFullName("Gonzalo Ramos Zúñiga");
        assertEquals("Gonzalo Ramos Zúñiga", member.getFullName());
    }

    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        Member member = new Member();
        member.setEmailAddress("gramoszuniga5711@conestogac.on.ca");
        assertEquals("gramoszuniga5711@conestogac.on.ca",
                member.getEmailAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Member member = new Member();
        member.setPhoneNumber("123-123-1234");
        assertEquals("123-123-1234", member.getPhoneNumber());
    }

    @Test
    public void testGetProgramName() {
        System.out.println("getProgramName");
        Member member = new Member();
        member.setProgramName("CPA");
        assertEquals("CPA", member.getProgramName());
    }

    @Test
    public void testGetYearLevel() {
        System.out.println("getYearLevel");
        Member member = new Member();
        member.setYearLevel(2);
        assertEquals(2, member.getYearLevel());
    }

    @Test
    public void testValidNegative() {
        System.out.println("isValidNegative");
        Member member = new Member();
        assertEquals(false, member.isValid());
    }

    @Test
    public void testValidPositive() {
        System.out.println("isValidPositive");
        Member member = new Member("Gonzalo Ramos Zúñiga",
                "gramoszuniga5711@conestogac.on.ca");
        assertEquals(true, member.isValid());
    }
}
