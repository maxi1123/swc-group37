import cards.Gold_CC;
import cards.Platinum_CC;
import cards.Regular_CC;
import customers.Customer;
import customers.Gold;
import customers.Platinum;
import customers.Regular;
import employees.*;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    @org.junit.jupiter.api.Test
    void testGoldLimit() //makes sure that the limit for gold cards works
    {
        Gold gold = new Gold("Max", "Mustermann", 32, 12345, 15000, 12345);
        Gold_CC goldcard = new Gold_CC("Max", "Mustermann", 32, 12345, 1500);
        gold.setCreditcard(goldcard);
        assertEquals(gold.getCreditcard().getLimit(), 5000);
    }

    @org.junit.jupiter.api.Test
    void testPlatLimit() //makes sure that the limit for platinum cards works
    {
        Platinum plat = new Platinum("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC platcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        plat.setCreditcard(platcard);
        assertEquals(plat.getCreditcard().getLimit(), 10000);
    }

    @org.junit.jupiter.api.Test
    void testRegLimit() //makes sure that the limit for regular cards works
    {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        assertEquals(reg.getCreditcard().getLimit(), 2000);
    }

    @org.junit.jupiter.api.Test
    void testMainChiefGold() //makes sure that main chief can upgrade regular accounts to gold
    {
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
    void testMainChiefPlat() //makes sure that main chief can upgrade gold accounts to platinum
    {
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
    void testSectionChiefUpgradePlat() //makes sure that section chiefs can upgrade gold accounts to platinum
    {
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
    void testMainChiefDonwgradePlatToReg() //makes sure that can downgrade platinum accounts to regular
    {
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
    void testMainChiefDowngradeReg() //makes sure that main chief cant downgrade a regular account
    {
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
    void testRegularEmployeeUpgradeGold() //makes sure that regular employees can upgrade customers to gold
    {
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
    void testRegularEmployeeWrongUpgrade() //makes sure that regular employees cant accidentally "upgrade" a platinum card to gold
    {
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
    void transferLimit() //makes sure that money transfers dont exceed the savings amount
    {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        reg.transferPayment(16000);
        assertEquals(reg.withdraw(15000),15000);
    }

    @org.junit.jupiter.api.Test
    void withdrawLimit() //makes sure that withdrawing works correctly
    {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        reg.withdraw(16000);
        assertEquals(reg.withdraw(15000),15000);
    }

    @org.junit.jupiter.api.Test
    void transferNotCCLimit() //makes sure that money transfers work even when the amount is higher than the cards limit
    {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        reg.transferPayment(14000);
        assertEquals(reg.withdraw(1000),1000);
    }

    @org.junit.jupiter.api.Test
    void depositTest() //makes sure that deposit works for customers
    {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        reg.deposit(5000);
        assertEquals(reg.getSavings(), 20000 );
    }

    @org.junit.jupiter.api.Test
    void testDowngradeGoldToRegular() //makes sure that the downgradeGold funtionality works
    {
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
    void testDowngradePlatinumToGold() //makes sure that downgradePlatinumToGold works
    {
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
    void testTransferCardNotPossible()  //makes sure that card payments over the limit is not possible
    {
        Platinum plat = new Platinum("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC platcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        String check = "The specified amount exceeds your credit card limit.";
        plat.setCreditcard(platcard);
        assertEquals(plat.transferCard(12000), check);
    }

    @org.junit.jupiter.api.Test
    void testTransferCardPossible() //makes sure that card payments are possible
    {
        Platinum plat = new Platinum("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC platcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        String check = "Transfer complete.";
        plat.setCreditcard(platcard);
        assertEquals(plat.transferCard(9000), check);
    }

    @org.junit.jupiter.api.Test
    void fixBackEndTest() //makes sure that fixBackend works for BackendTechs
    {
        BackendTech backend = new BackendTech("max", "musti", 123);
        assertEquals(backend.fixBackend(123), "Fixed!");
    }

    @org.junit.jupiter.api.Test
    void employeeAddCardToCustomerTest() //makes sure that an employee can add a card to a customer
    {
        Gold gold = new Gold("Max", "Mustermann", 32, 12345, 15000, 12345);
        Gold_CC goldcard = new Gold_CC("Max", "Mustermann", 32, 12345, 1500);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(gold);
        RegularEmployee bankpleb = new RegularEmployee("Whack", "Man", 7, clist);
        bankpleb.addCardToCustomer(goldcard, gold);
        assertEquals(gold.getCreditcard().getLimit(), 5000);
    }

    @org.junit.jupiter.api.Test
    void testMainChiefDowngradeGold() //makes sure that main chief can downgrade gold cards
    {
        Gold gold = new Gold("Max", "Mustermann", 32, 12345, 15000, 12345);
        Gold_CC goldcard = new Gold_CC("Max", "Mustermann", 32, 12345, 1500);
        gold.setCreditcard(goldcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(gold);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.downgradeGold(12345);
        assertEquals(gold.getCreditcard().getLimit(), 2000);
    }

    @org.junit.jupiter.api.Test
    void testMainChiefDowngradeGoldNotPossible() //makes sure that downgradeGold can't be used on Platinum cards
    {
        Gold gold = new Gold("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC goldcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        gold.setCreditcard(goldcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(gold);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.downgradeGold(12345);
        assertEquals(gold.getCreditcard().getLimit(), 10000);
    }

    @org.junit.jupiter.api.Test
    void testMainChiefUpgradePlatinumNotPossible() //makes sure main chief cant upgrade a platinum card to platinum
    {
        Gold gold = new Gold("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC goldcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        gold.setCreditcard(goldcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(gold);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.upgradePlatinum(12345);
        assertEquals(gold.getCreditcard().getLimit(), 10000);
    }

    @org.junit.jupiter.api.Test
    void testMainChiefDowngradePlatinumToRegularNotPossible() //makes sure that main chief cant use DowngradePlatinum to regular on gold cards
    {
        Gold gold = new Gold("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC goldcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        gold.setCreditcard(goldcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(gold);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.downgradePlatinumToRegular(12345);
        assertEquals(gold.getCreditcard().getLimit(), 2000);
    }

    @org.junit.jupiter.api.Test
    void testSectionChiefDowngradeGoldNotPossible() //makes sure that section chiefs can not use downgradeGold on a regular card
    {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        SectionChief section = new SectionChief("Whack", "Man", 1, clist, "Ouagadougou");
        section.downgradeGold(12345);
        assertEquals(reg.getCreditcard().getLimit(), 2000);
    }

    @org.junit.jupiter.api.Test
    void testSectionChiefUpgradePlatinumNotPossible() //makes sure that section chiefs cannot upgrade people to platinum
    {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        SectionChief section = new SectionChief("Whack", "Man", 1, clist, "Ouagadougou");
        section.upgradePlatinum(12345);
        assertEquals(reg.getCreditcard().getLimit(), 2000);
    }

    @org.junit.jupiter.api.Test
    void testWebTechFixWebsite() //tests whether fixWebsite works for WebTechs
    {
        WebTech webtech = new WebTech("max", "musti", 123);
        String check = "Reparations complete.";
        assertEquals(webtech.fixWebsite(), check);
    }
}
