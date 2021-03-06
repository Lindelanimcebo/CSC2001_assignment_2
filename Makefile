JAVAC=/usr/bin/javac
JAVADOC=/usr/bin/javadoc
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
LOGSDIR=logs
DATADIR=data
DOCDIR=doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<
	
CLASSES=Entry.class \
BinaryTreeNode.class BTQueueNode.class BTQueue.class  BinaryTree.class \
BinarySearchTree.class AVLTree.class \
BTHelper.class LSBSTApp.class LSAVLTApp.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class
	rm $(LOGSDIR)/*

clean-backup:
	rm ./*~
	rm ./*/*~

clean-docs:
	rm $(DOCDIR)/*
	
clean-t:
	rm $(DATADIR)/*test*
	rm $(LOGSDIR)/*test*
	rm $(LOGSDIR)/*.png

clean-all:
	rm $(BINDIR)/*.class
	rm $(LOGSDIR)/*
	rm $(DOCDIR)/*
	rm $(DATADIR)/*test*
	rm ./*~
	rm ./*/*~
docs:
	javadoc -d doc/ src/*.java

runA:
	java -cp bin LSAVLTApp $(stage) $(day) $(time) > ./logs/logs.txt

runB:
	java -cp bin LSBSTApp $(stage) $(day) $(time) > ./logs/logs.txt
	
test:
	python3.8 scripts/runTests.py