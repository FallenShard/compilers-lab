import java.util.Hashtable;

public class MyTable
{

	private final Hashtable m_table;
    
	public MyTable()
	{
		// Initialize hash table that keeps the keywords
		m_table = new Hashtable();
		m_table.put("main", MySym.MAIN);
		m_table.put("int",  MySym.INT);
		m_table.put("char", MySym.CHAR);
		m_table.put("real", MySym.REAL);
		m_table.put("bool", MySym.BOOL);
		m_table.put("read", MySym.READ);
		m_table.put("write", MySym.WRITE);
		m_table.put("while", MySym.WHILE);
		m_table.put("true", MySym.TRUE);
		m_table.put("false", MySym.FALSE);
	}
	
	/**
	 * Returns id of the keyword within the hash
     * @param keyword
     * @return 
	 */
	
	public int find(String keyword)
	{
		Object symbol = m_table.get(keyword);
		if (symbol != null)
			return ((int)symbol);
		
		// If a word doesn't belong to the table, it could be an identifier
		return MySym.ID;
	}
	

}
