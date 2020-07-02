package Tests;

import org.junit.Before;
import org.junit.Test;

import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTests {
    Job job1;
    Job job2;
    Job job3;
    Job aJob;

    @Test
    public void testSettingJobId(){
        int job1Id = job1.getId();
        int job2Id = job2.getId();
        assertTrue(job2Id-job1Id == 1);
    }

    @Before
    public void createJobObjects(){
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        aJob = new Job("Dev", new Employer("Employer"), new Location("The Moon"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job aJob = new Job("Dev", new Employer("Employer"), new Location("The Moon"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job anotherJob = new Job("Dev", new Employer("Employer"), new Location("The Moon"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(aJob, anotherJob);
    }
    @Test
    public void testStringReturnWithBlankLinesBeforeAndAfterJobInfo(){
        assertTrue(job3.toString().startsWith("\n"));
        assertTrue(aJob.toString().endsWith("\n"));
    }

    @Test
    public void testStringContainsLabelForEachFieldWithData(){
        // Test Labels
        System.out.println(job3.toString());
        assertTrue(job3.toString().contains("ID:"));
        assertTrue(job3.toString().contains("Name:"));
        assertTrue(job3.toString().contains("Employer:"));
        assertTrue(job3.toString().contains("Location:"));
        assertTrue(job3.toString().contains("Position Type:"));
        assertTrue(job3.toString().contains("Core Competency:"));
        // Test Data Assigned to Labels
        assertTrue(job3.toString().contains("Product tester"));
        assertTrue(job3.toString().contains("ACME"));
        assertTrue(job3.toString().contains("Desert"));
        assertTrue(job3.toString().contains("Quality control"));
        assertTrue(job3.toString().contains("Persistence"));
    }

    @Test
    public void testEmptyFieldDataNotAvailableAlert(){
        System.out.println(job1);
        System.out.println(job3);
        assertTrue(job1.toString().contains("Data Not Available"));
    }
}
