import cards.*;
import customers.*;
import employees.*;
import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public  class Tests {
    @Test //checks that the limit for gold cards gets set correctly
    public void TestGoldLimit() {
        Gold gold = new Gold("Max", "Mustermann", 32, 12345, 15000, 12345);
        Gold_CC goldcard = new Gold_CC("Max", "Mustermann", 32, 12345, 1500);
        gold.setCreditcard(goldcard);
        assertEquals(gold.getCreditcard().getLimit(), 5000);
    }

    @Test //checks that the limit for platinum cards gets set correctly
    public void TestPlatLimit() {
        Platinum plat = new Platinum("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC platcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        plat.setCreditcard(platcard);
        assertEquals(plat.getCreditcard().getLimit(), 10000);
    }

    @Test //checks that the limit for regular cards is set correcty
    public void TestRegLimit() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        assertEquals(reg.getCreditcard().getLimit(), 2000);
    }

    @Test //checks whether the Main Chief can upgrade customers to gold
    public void TestMainChiefGold() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.upgradeGold(12345);
        assertEquals(reg.getCreditcard().getLimit(), 5000);
    }

    @Test //checks if Main Chief can upgrade customer to platinum
    public void TestMainChiefPlat() {
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

    @Test //tests if platinum upgrade also works for Section Chiefs
    public void TestSectionChiefUpgradePlat() {
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

    @Test //tests that Main Chief can downgrade customers from platinum to regular
    public void TestMainChiefDonwgradePlatToReg() {
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
    @Test //tests that main chief can not use "downgrade from platinum to gold" on regular customers
    public void TestMainChiefDowngradeReg() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        MainChief main = new MainChief("Boss", "Man", 1, clist);
        main.downgradePlatinumToGold(12345);
        assertEquals(reg.getCreditcard().getLimit(), 2000);
    }
    @Test //tests if normal bank employee can upgrade to gold
    public void TestBankEmployeeUpgradeGold() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        BankEmployee bankpleb = new BankEmployee("Whack", "Man", 7, clist);
        bankpleb.upgradeGold(12345);
        assertEquals(reg.getCreditcard().getLimit(), 5000);
    }
    @Test //tests that normal bank employees cant wrongly "upgrade" platinum to gold
    public void TestBankEmployeeWrongUpgrade() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Platinum_CC regcard = new Platinum_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        ArrayList<Customer> clist = new ArrayList<>();
        clist.add(reg);
        BankEmployee bankpleb = new BankEmployee("Whack", "Man", 7, clist);
        bankpleb.upgradeGold(12345);
        assertEquals(reg.getCreditcard().getLimit(), 10000);
    }
    @Test //tests transfer limit
    public void TransferLimit() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        reg.transferPayment(16000);
        assertEquals(reg.withdraw(15000),15000);
    }
    @Test //tests overdrafting
    public void WithdrawLimit() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        reg.withdraw(16000);
        assertEquals(reg.withdraw(15000),15000);
    }
    @Test //tests that transfers dont use CC limit
    public void TransferNotCCLimit() {
        Regular reg = new Regular("Max", "Mustermann", 32, 12345, 15000, 12345);
        Regular_CC regcard = new Regular_CC("Max", "Mustermann", 32, 12345, 1500);
        reg.setCreditcard(regcard);
        reg.transferPayment(14000);
        assertEquals(reg.withdraw(1000),1000);
    }

}
