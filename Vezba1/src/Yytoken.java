class Yytoken
{
	public int m_index;
	public String m_text;
	public int m_line;
	public int m_charBegin;
	Yytoken (int index, String text, int line, int charBegin)
	{
		m_index = index;
		m_text = text;
		m_line = line;
		m_charBegin = charBegin;
		}

    @Override
	public String toString()
    {
		return "Text : " + m_text +
		"\tindex : " + m_index +
		"\tline : " + m_line +
		"\tcBeg. : " + m_charBegin;
	}
}