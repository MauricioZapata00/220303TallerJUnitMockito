import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class DependencyVerifyTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Dependency dependency;

    @Test
    public void testSimpleVerify(){
        verify(this.dependency, never()).getClassNameUpperCase();
        this.dependency.getClassNameUpperCase();

        verify(this.dependency, times(1)).getClassNameUpperCase();

        verify(this.dependency, atLeast(1)).getClassNameUpperCase();
        this.dependency.getClassNameUpperCase();

        verify(this.dependency, atMost(2)).getClassNameUpperCase();
    }

    @Test
    public void testParameters(){
        this.dependency.addTwo(3);
        verify(this.dependency, times(1)).addTwo(3);
        this.dependency.addTwo(4);

        verify(this.dependency, times(2)).addTwo(anyInt());
    }
}
