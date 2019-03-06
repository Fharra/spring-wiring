import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.spring.wiring.ApplicationContextTestResourceNameType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ApplicationContextTestResourceNameType.class)
public class FieldResourceInjectionTest {

	@Resource
	@Qualifier("defaultFile")
	private File dependency1;

	@Resource
	@Qualifier("namedFile")
	private File dependency2;

	@Test
	public void givenResourceAnnotation_WhenOnField_ThenDependency1Valid() {
		assertNotNull(dependency1);
		assertEquals("defaultFile.txt", dependency1.getName());
	}

	@Test
	public void givenResourceAnnotation_WhenOnField_ThenDependency2Valid() {
		assertNotNull(dependency2);
		assertEquals("namedFile.txt", dependency2.getName());
	}
}
