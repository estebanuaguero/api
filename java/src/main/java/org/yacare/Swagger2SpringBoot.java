package org.yacare;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.utiljdbc.DataSourceWrapper;
import org.utiljdbc.SO;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "org.yacare")
public class Swagger2SpringBoot implements CommandLineRunner {

	private final static String MSG_1 = "Error al levantar las propiedades de configuración.";

	private static String urlFiles; // URL de Repositorio de Archivos
	private static Properties properties;
	private static DataSourceWrapper dataSourceWrapper;

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {

		new SpringApplication(Swagger2SpringBoot.class).run(args);

		if (args.length > 0 && args[0].trim().startsWith("-p")) {
			urlFiles = args[0].replaceFirst("-p", "");
		}

		init();
		
//		new Test().test2();
//		new Test().test();
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}

	private static void init() {

		if (dataSourceWrapper == null) {
			if (urlFiles == null) {
				// urlFiles =
				// "/home/java/Dropbox/dev/ws_servlet/Yacare/yacare_files/yacare.properties";
				urlFiles = "/opt/yacare_api/yacare.properties";
			}

			System.out.println("\n[..] Leyendo el archivo de configuración "
					+ urlFiles);

			System.out.println("\n[OK] Archivo de configuración " + urlFiles
					+ " levantado.");

			System.out
					.println("\n[==================================== START - CONTENIDO DEL ARCHIVO DE CONFIGURACION ===================================================]\n\n"

							+ SO.readFilePlainText(urlFiles)

							+ "\n[====================================  END - CONTENIDO DEL ARCHIVO DE CONFIGURACION ===================================================]\n");

			if (properties == null) {
				properties = new Properties();
			}
			try {
				properties.load(new FileInputStream(urlFiles));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(MSG_1);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(MSG_1);
			}
			dataSourceWrapper = new DataSourceWrapper(properties);
		}
	}

	public static DataSourceWrapper getDataSourceWrapper() {
		return dataSourceWrapper;
	}

}