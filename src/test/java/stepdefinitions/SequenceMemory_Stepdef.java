package stepdefinitions;

import java.io.IOException;


import commonUtilities.AbstractPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SequenceMemoryPage;

public class SequenceMemory_Stepdef extends AbstractPage{

	SequenceMemoryPage sequenceMemoryPage = new SequenceMemoryPage();

	@And("user starts Sequence Memory Test")
	public void userStartsSequenceMemoryTest() throws IOException, InterruptedException {
		sequenceMemoryPage.startSequenceMemoryTest();
	}
	
	@And("user complete Sequence Memory Test")
	public void userCompleteSequenceMemoryTest() throws IOException, InterruptedException {
		sequenceMemoryPage.completeSequenceMemoryTest();
	}
}
