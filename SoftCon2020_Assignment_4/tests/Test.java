import cards.Gold_CC;
import cards.Platinum_CC;
import cards.Regular_CC;
import customers.Customer;
import customers.Gold;
import customers.Platinum;
import customers.Regular;
import employees.MainChief;
import employees.RegularEmployee;
import employees.SectionChief;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    @org.junit.jupiter.api.Test
    void testGoldLimit() {
        Gold gold = new Gold("Max", "Mustermann", 32, 12345, 15000, 12345);
        Gold_CC goldcard = new Gold_CC("Max", "Mustermann", 32, 12345, 1500);
        gold.setCreditcard(goldcard);
        assertEquals(gold.getCreditcard().getLimit(), 5000);
    }

    @org.junit.jupiter.api.Test
    void testPlatLimit() {
        Platinum plat = new Platinum("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC platcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        plat.setCreditcard(platcard);
        assertEquals(plat.getCreditcard().getLimit(), 10000);
    }

    @org.junit.jupiter.api.Test
    void testRegLimit() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        assertEquals(reg.getCreditcard().getLimit(), 2000);
    }

    @org.junit.jupiter.api.Test
    void testMainChiefGold() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.upgradeGold(12345);
        assertEquals(reg.getCreditcard().getLimit(), 5000);
    }

    @org.junit.jupiter.api.Test
    void testMainChiefPlat() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.upgradeGold(12345);
        main.upgradePlatinum(12345);
        assertEquals(reg.getCreditcard().getLimit(), 10000);
    }

    @org.junit.jupiter.api.Test
    void testSectionChiefUpgradePlat() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        SectionChief section = new SectionChief("Whack", "Man", 1, clist, "Ouagadougou");
        section.upgradeGold(12345);
        section.upgradePlatinum(12345);
        assertEquals(reg.getCreditcard().getLimit(), 10000);
    }

    @org.junit.jupiter.api.Test
    void testMainChiefDonwgradePlatToReg() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.upgradeGold(12345);
        main.upgradePlatinum(12345);
        main.downgradePlatinumToRegular(12345);
        assertEquals(reg.getCreditcard().getLimit(), 2000);
    }

    @org.junit.jupiter.api.Test
    void testMainChiefDowngradeReg() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.downgradePlatinumToGold(12345);
        assertEquals(reg.getCreditcard().getLimit(), 2000);
    }

    @org.junit.jupiter.api.Test
    void testRegularEmployeeUpgradeGold() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        RegularEmployee bankpleb = new RegularEmployee("Whack", "Man", 7, clist);
        bankpleb.upgradeGold(12345);
        assertEquals(reg.getCreditcard().getLimit(), 5000);
    }

    @org.junit.jupiter.api.Test
    void testRegularEmployeeWrongUpgrade() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC regcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        RegularEmployee bankpleb = new RegularEmployee("Whack", "Man", 7, clist);
        bankpleb.upgradeGold(12345);
        assertEquals(reg.getCreditcard().getLimit(), 10000);
    }

    @org.junit.jupiter.api.Test
    void transferLimit() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        reg.transferPayment(16000);
        assertEquals(reg.withdraw(15000),15000);
    }

    @org.junit.jupiter.api.Test
    void withdrawLimit() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        reg.withdraw(16000);
        assertEquals(reg.withdraw(15000),15000);
    }

    @org.junit.jupiter.api.Test
    void transferNotCCLimit() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        reg.transferPayment(14000);
        assertEquals(reg.withdraw(1000),1000);
    }

    @org.junit.jupiter.api.Test
    void depositTest(){
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        reg.deposit(5000);
        assertEquals(reg.getSavings(), 20000 );
    }

    @org.junit.jupiter.api.Test
    void testDowngradeGoldToRegular(){
        Gold gold = new Gold("Max", "Mustermann", 32, 12345, 15000, 12345);
        Gold_CC goldcard = new Gold_CC("Max", "Mustermann", 32, 12345, 1500);
        gold.setCreditcard(goldcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(gold);
        SectionChief section = new SectionChief("Whack", "Man", 1, clist, "Ouagadougou");
        section.downgradeGold(12345);
        assertEquals(gold.getCreditcard().getLimit(), 2000);
    }

    @org.junit.jupiter.api.Test
    void testDowngradePlatinumToGold(){
        Platinum plat = new Platinum("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC platcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        plat.setCreditcard(platcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(plat);
        MainChief chief = new MainChief("Whack", "Man", 1, clist);
        chief.downgradePlatinumToGold(12345);
        assertEquals(plat.getCreditcard().getLimit(), 5000);
    }

    @org.junit.jupiter.api.Test
    void testTransferCardNotPossible(){
        Platinum plat = new Platinum("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC platcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        String check = "The specified amount exceeds your credit card limit.";
        plat.setCreditcard(platcard);
        assertEquals(plat.transferCard(12000), check);
    }

    @org.junit.jupiter.api.Test
    void testTransferCardPossible(){
        Platinum plat = new Platinum("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC platcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        String check = "Transfer complete.";
        plat.setCreditcard(platcard);
        assertEquals(plat.transferCard(9000), check);
    }
}