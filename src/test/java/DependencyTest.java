import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DependencyTest {

    @Mock
    private Dependency dependency;

    @Before
    public void setupMock(){

        this.dependency = mock(Dependency.class);
    }

    @Test
    public void testDependency(){
        when(this.dependency.getClassName()).thenReturn("Hi there!");

        Assert.assertEquals("Hi there!", this.dependency.getClassName());
    }

    @Test
    public void testAddTwoAny(){
        when(this.dependency.addTwo(anyInt())).thenReturn(0);

        Assert.assertEquals(0, this.dependency.addTwo(3));
        Assert.assertEquals(0, this.dependency.addTwo(80));
    }
}
