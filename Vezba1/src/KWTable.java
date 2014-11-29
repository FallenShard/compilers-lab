
import java.util.Hashtable;
public class KWTable {

	private final Hashtable mTable;
	public KWTable()
	{
		// Inicijalizcaija hash tabele koja pamti kljucne reci
		mTable = new Hashtable();
		mTable.put("PROGRAM", sym.PROGRAM);
		mTable.put("VAR", sym.VAR);
		mTable.put("INTEGER", sym.INTEGER);
		mTable.put("CHAR", sym.CHAR);
		mTable.put("BEGIN", sym.BEGIN);
		mTable.put("END", sym.END);
		mTable.put("READ", sym.READ);
		mTable.put("WRITE", sym.WRITE);
		mTable.put("IF", sym.IF);
		mTable.put("THEN", sym.THEN);
		mTable.put("ELSE", sym.ELSE);
	}
	
	/**
	 * Vraca ID kljucne reci 
     * @param keyword
     * @return 
	 */
	
	public int find(String keyword)
	{
		Object symbol = mTable.get(keyword);
		if (symbol != null)
			return ((int)symbol);
		
		// Ako rec nije pronadjena u tebali kljucnih reci radi se o identifikatoru
		return sym.ID;
	}
	

}
