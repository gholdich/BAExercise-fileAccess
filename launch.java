package fileAccess;

import java.io.File;

public class launch {
	private static processFile processfile = new processFile();
	private static Entity entity = new Entity();

	public static void main(String[] args) {
		StringBuilder sb = processfile.buildStringFromFile(new File(System.getProperty("user.home") + File.separator + "ExData.txt"));
		entity.addPersons(sb);
		entity.addAnimals(sb);
		entity.splitStringToObjects(sb);
		entity.processEntitys();
		entity.processDialog();
	}

}
