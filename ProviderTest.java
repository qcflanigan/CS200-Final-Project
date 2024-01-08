
import static org.junit.Assert.*;

import java.io.IOException;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

class ProviderTest {
	Provider provider=new Provider("qcflanigan@crimson.ua.edu","jcpsQF7641", "12041273", "812 Beechwood rd", "Louisville", "Kentucky", "40207", "Quillen Flanigan");
	Manager m=new Manager();
	
	@Test
	void ProviderSuccess() {
		
		assertTrue(provider.GetProviderCity()=="Louisville");
		assertTrue(provider.GetProviderID()=="12041273");
		assertTrue(provider.GetProviderName()=="Quillen Flanigan");
		
		Provider temp = provider.GetProvider(provider.GetProviderID());
		assertTrue(temp.GetProviderAddress()=="812 Beechwood rd");
	}
	
	@Test(expected=NumberFormatException.class)
	void BillChocAnException() {
		Service s=new Service();
		s.setServDate("04-28-2022");
		s.setMembNum("123456789");
		s.setServCode("123456");
		boolean worked=provider.BillChocAn("-1", s.getMembNum(), "0", "no comments");
		assertFalse(worked==true);

}
	
	@Test
	void MemberSuccess() {
		boolean worked=m.ProviderReport();
		assertTrue(worked==true);
	}
	
	
	
	
}

