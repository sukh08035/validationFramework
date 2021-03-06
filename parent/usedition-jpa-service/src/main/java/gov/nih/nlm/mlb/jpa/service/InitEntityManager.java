package gov.nih.nlm.mlb.jpa.service;


import gov.nih.nlm.mlb.snomedct.config.ConfigUtility;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public abstract class InitEntityManager {

	protected static EntityManagerFactory factory;
	protected EntityManager manager;
	protected boolean transactionPerOperation = true;
	protected EntityTransaction tx;
	protected Logger logger = Logger.getLogger(this.getClass()+" Setting Logger ofr LoadDataFromRF2");
	public InitEntityManager() throws Exception {
		// created once or if the factory has closed
		if (factory == null || !factory.isOpen()) {
			openFactory();
		}
		manager = factory.createEntityManager();
		tx = manager.getTransaction();
	}

	public synchronized void openFactory() throws Exception {

		if (factory == null || !factory.isOpen()) {
			logger.info("Setting root service entity manager factory.");
			Properties config = ConfigUtility.getJpaPropterties();
			factory =
					Persistence.createEntityManagerFactory("usedition-jpa-model", config);
		}

	}
	public void closeFactory() throws Exception {
		if (factory.isOpen()) {
			factory.close();
		}
	}
	

	  public boolean getTransactionPerOperation() {
	    return transactionPerOperation;
	  }


	  public void setTransactionPerOperation(boolean transactionPerOperation) {
	    this.transactionPerOperation = transactionPerOperation;
	  }


	  public void beginTransaction() {

	    if (getTransactionPerOperation())
	      throw new IllegalStateException(
	          "Error attempting to begin a transaction when using transactions per operation mode.");
	    else if (tx != null && tx.isActive())
	      throw new IllegalStateException(
	          "Error attempting to begin a transaction when there "
	              + "is already an active transaction");
	    tx = manager.getTransaction();
	    tx.begin();
	  }

	
	  public void commit() throws Exception {

	    if (getTransactionPerOperation())
	      throw new IllegalStateException(
	          "Error attempting to commit a transaction when using transactions per operation mode.");
	    else if (tx != null && !tx.isActive())
	      throw new IllegalStateException(
	          "Error attempting to commit a transaction when there "
	              + "is no active transaction");
	    if (tx == null) {
	      throw new Exception("Attempting to commit a null transaction.");
	    }
	    tx.commit();
	    manager.clear();
	  }
	  
	
	  public void clear() throws Exception {
	    manager.clear();
	  }

	public void save(Object obj)
	{
		tx =manager.getTransaction();  
		tx.begin();	
		manager.persist(obj);
		tx.commit();
	}
	  public void closeEntityManager() throws Exception {
	    if (manager.isOpen()) {
	      manager.close();
	    }
	  }
	
}
