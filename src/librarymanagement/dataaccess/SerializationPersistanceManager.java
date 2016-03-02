package librarymanagement.dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class SerializationPersistanceManager<T> {
	
	private static final String STORAGE_LOCATION = "storage/";
	
	private String storageFile;
	//private List<T> records;
	
	public SerializationPersistanceManager(String storageFile){
		this.storageFile = storageFile;
		//records = getEntityList();
	}
	
	@SuppressWarnings("unchecked")
	protected final List<T> getEntityList(){
		ObjectInputStream objIn;

		List<T> objects = new ArrayList<>();	
		File file = new File(STORAGE_LOCATION+storageFile);
		
		if(!file.isFile()){
			saveEntity(new ArrayList<T>());
		}
		try {
							
			objIn = new ObjectInputStream (new FileInputStream(STORAGE_LOCATION+storageFile ));
			try {
				objects = (List<T>) objIn.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	protected final T getEntity(){
		ObjectInputStream objIn;
		T obj = null;
		try {
			objIn = new ObjectInputStream (new FileInputStream(storageFile ));
			obj = (T) objIn.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		return obj;
	}
	
	protected final void saveEntity(List<T> objList){
		File file = new File(STORAGE_LOCATION);
		if(!file.exists()){
			file.mkdir();
		}

		file = new File(STORAGE_LOCATION+storageFile);
		try {
			// File outputFile = new File(STORAGE_LOCATION+ storageFile);
			    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			
			    os.writeObject ( objList );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	protected final void saveEntity(T obj){
		//file = STORAGE_LOCATION+file;

		
		try {
			ObjectOutputStream objOut = new ObjectOutputStream (new FileOutputStream(storageFile));
			
			objOut.writeObject ( obj );
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}*/
}
