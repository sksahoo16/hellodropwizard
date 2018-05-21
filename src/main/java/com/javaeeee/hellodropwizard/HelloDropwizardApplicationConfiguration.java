package com.javaeeee.hellodropwizard;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;

import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;



public class HelloDropwizardApplicationConfiguration extends Configuration {
	private static final String DATABASE = "database";

	  @Valid
	  @NotNull
	  private DataSourceFactory dataSourceFactory = new DataSourceFactory();

	  @JsonProperty(DATABASE)
	  public DataSourceFactory getDataSourceFactory() {
	    return dataSourceFactory;
	  }

	  @JsonProperty(DATABASE)
	  public void setDataSourceFactory(final DataSourceFactory dataSourceFactory) {
	    this.dataSourceFactory = dataSourceFactory;
	  }

}
