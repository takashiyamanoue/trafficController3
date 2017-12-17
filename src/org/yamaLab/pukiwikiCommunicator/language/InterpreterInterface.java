package org.yamaLab.pukiwikiCommunicator.language;

public interface InterpreterInterface
{
	public String getOutputText();
	public boolean isTracing();
	public String parseCommand(String x);
	public String parseCommandWithReturn(String x, String y);
	public InterpreterInterface lookUp(String x);
}
