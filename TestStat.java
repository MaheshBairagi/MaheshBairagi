import static org.junit.Assert.*;

import org.junit.Test;

import com.ts.domain.SignalStatistics;
import com.ts.processor.Processor;

public class TestStat {

	@Test
	public void test() {
		//checking stat at 7th second
		
		Processor.activateSignal(3, 1, 8);
		SignalStatistics stat=Processor.getSignalStatAtInstance(7);
		assertEquals(5,stat.getEastCount(),0 );
		
		assertEquals(5,stat.getWestCount(),0 );
		
		
		assertEquals(4,stat.getNorthCount(),0 );
		
		assertEquals(4,stat.getSouthCount(),0 );
		
		
	}

	@Test
	public void testStat() {
		//checking stat at 7th second
		
		Processor.activateSignal(3, 1, 5);
		SignalStatistics stat=Processor.getSignalStatAtInstance(4);
		assertEquals(4,stat.getEastCount(),0 );
		
		assertEquals(4,stat.getWestCount(),0 );
		
		
		assertEquals(1,stat.getNorthCount(),0 );
		
		assertEquals(1,stat.getSouthCount(),0 );
	
		
	}


}
