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
	rm -f $(LOGSDIR)/*
	rm -f $(BINDIR)/*.class

clean-backup:
	rm -f ./*~
	rm -f ./*/*~

clean-docs:
	rm -f $(DOCDIR)/*
	
clean-t:
	rm -f $(DATADIR)/*test*
	rm -f $(LOGSDIR)/*test*
	rm -f $(LOGSDIR)/*.png

clean-all:
	rm -f $(BINDIR)/*.class
	rm -f $(LOGSDIR)/*
	rm -f $(DOCDIR)/*
	rm -f $(DATADIR)/*test*
	rm -f ./*~
	rm -f ./*/*~
docs:
	javadoc -d doc/ src/*.java

runA:
	java -cp bin LSAVLTApp $(stage) $(day) $(time) > ./logs/logs.txt

runB:
	java -cp bin LSBSTApp $(stage) $(day) $(time) > ./logs/logs.txt
	
test:
	python3.8 scripts/runTests.py