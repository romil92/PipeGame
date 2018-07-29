package Server;

public interface CacheManager {

	public String load();
	void save(String hash, String solution);
	
}
