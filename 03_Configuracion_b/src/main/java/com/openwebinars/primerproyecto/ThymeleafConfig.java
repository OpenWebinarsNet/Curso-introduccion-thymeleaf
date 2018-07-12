package com.openwebinars.primerproyecto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Esta clase configura los mismos aspectos que han sido configurados en el proyecto
 * 03_Configuracion_a a través de application.properties.
 * 
 * @author luismi
 * 
 *
 */
@Configuration
public class ThymeleafConfig implements ApplicationContextAware {

	// Nuestro SpringResourceTemplateResolver necesita una referencia al ApplicationContext
	// de la aplicación. Por eso implementamos ApplicationContextAware, definimos esta
	// referencia e implementamos el método de más abajo
	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	// Este bean, de tipo SpringResourceTemplateResolver, es el que resolverá
	// la plantilla que vamos a utilizar. Podríamos decir, grosso modo, que es
	// quien la localizará.
	@Bean
	public SpringResourceTemplateResolver templateResolver() {

		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(this.applicationContext);
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		//templateResolver.setCacheable(true);
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	// El bean de tipo SpringTemplateEngine será el motor que procese la plantilla
	// Habilitamos el compilador de expresiones EL, que acelerará el procesamiento
	// de expresiones, pero puede dar problemas con plantillas antiguas.
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		//engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		return engine;
	}

	// Toda aplicación de Spring MVC necesita un ViewResolver, que le permita
	// resolver que vista utilizar. Podemos apreciar como estos beans, van
	// encadenados (templateResolver -> templateEnginge -> viewResolver).
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}

}
