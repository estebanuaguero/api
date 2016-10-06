package org.yacare;

import java.util.Arrays;

import org.cendra.commons.GeneralProperties;
import org.cendra.commons.utiljdbc.DataSourceWrapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "org.yacare")
public class MainYacare implements CommandLineRunner {

	public static GeneralProperties generalProperties;

	private static DataSourceWrapper dataSourceWrapper;

	@Override
	public void run(String... arg0) throws Exception {

		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new SpringApplication(MainYacare.class)
				.run(args);

		System.out.println("\n\nSpring Boot instantiated beans:\n");

		String[] beanNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println("\t\t- " + beanName);
		}

		init(args);

		// new Test().test2();
		// new Test().test();
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}

	private static void init(String[] args) {

		String urlFiles = null;

		if (args.length > 0 && args[0].trim().startsWith("-p")) {
			urlFiles = args[0].replaceFirst("-p", "");
		}

		generalProperties = new GeneralProperties();
		generalProperties.setUrlFiles(urlFiles);

		if (dataSourceWrapper == null) {
			dataSourceWrapper = new DataSourceWrapper(generalProperties.load());
		}
	}

	public static DataSourceWrapper getDataSourceWrapper() {
		return dataSourceWrapper;
	}

}