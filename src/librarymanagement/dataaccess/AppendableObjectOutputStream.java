package librarymanagement.dataaccess;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {

	protected AppendableObjectOutputStream(OutputStream out) throws IOException{
		super(out);
	}

	//No need to write header again and again when appending object
	@Override
	protected void writeStreamHeader() throws IOException {
		
		reset();
	}
	
	

}
