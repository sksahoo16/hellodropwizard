package com.javaeeee.hellodropwizard;

import javax.validation.Valid;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;


import io.dropwizard.db.DataSourceFactory;

public class HelloDropwizardConfiguration extends Configuration {
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
