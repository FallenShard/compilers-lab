/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FallenShard
 */
public class MyToken
{

	public int m_index;
	public String m_text;
	public int m_line;
	public int m_charBegin;
    
	MyToken (int index, String text, int line, int charBegin)
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
