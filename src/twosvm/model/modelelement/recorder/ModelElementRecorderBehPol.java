package twosvm.model.modelelement.recorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import twosvm.model.behavioralpolicy.BehPolicy;

import com.thoughtworks.xstream.XStream;

public class ModelElementRecorderBehPol {

	/**
	 * Grava uma modelos no formato XML
	 */
	public void saveModelElement(BehPolicy policy, String policyName, String modelType) {
		
		BehPolicy pol = new BehPolicy();
		pol = policy;
		String path = "./src/twosvm/" +modelType+ "/behaviouralpolicy/";

		XStream xStream = new XStream();
		xStream.alias("behaviourpolicy", BehPolicy.class);

		File file = new File(path + "" + policyName + ".xml");
		FileOutputStream record;

		try {
			record = new FileOutputStream(file);
			record.write(xStream.toXML(pol).getBytes());
			record.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
