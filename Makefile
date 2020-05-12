all: polling

polling: 
	javac HomeFrame.java

clean:
	rm -f polling *.class