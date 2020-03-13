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
	
CLASSES=Entry.class FileHelper.class \
BinaryTreeNode.class BTQueueNode.class BTQueue.class  BinaryTree.class \
BinarySearchTree.class AVLTree.class \
LSBST.class LSBSTApp.class \
LSAVLT.class LSAVLTApp.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class
	rm $(SRCDIR)/*~
	rm $(LOGSDIR)/*

clean-backup:
	rm ./*~
	rm ./*/*~
	
clean-t:
	rm $(DATADIR)/*test*
	rm $(LOGSDIR)/*test*
	rm $(LOGSDIR)/*.png
docs:
	javadoc -d doc/ src/*.java

runA:
	java -cp bin LSAVLTApp $(stage) $(day) $(time)

runB:
	java -cp bin LSBSTApp $(stage) $(day) $(time)
	
test:
	python3.8 scripts/runTests.py