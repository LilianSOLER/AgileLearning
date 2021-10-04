#!/bin/bash

#----------------------------------------------------------------------
# Checking this script is launched from where it is located,
# that is, the project directory "workspace/object.collections"
#----------------------------------------------------------------------
if [ ! -e $0 ] ; then
    echo "Launch the script from the directory where the script is."
    exit -1
fi
#----------------------------------------------------------------------
# Source setenv.sh to make the compilation uses the correct JDK,
#----------------------------------------------------------------------
if [ ! -e ../../setenv.sh ] ; then
    echo "Something is wrong, cannot find setenv.sh"
    exit -1
fi
source ../../setenv.sh

# cleanup the shell terminal
reset

#----------------------------------------------------------------------
# Let's compile the sources
#----------------------------------------------------------------------
FILES=`find collections -name "*.java"`
SRC=collections
BIN=collections.bin
JAR=edu-polytech-oop-collections.jar

rm -f $JAR

#----------------------------------------------------------------------
# Compiling sources
#----------------------------------------------------------------------
rm -rf $BIN
mkdir $BIN
PATHS="-sourcepath $SRC -classpath $BIN -s $BIN -d $BIN"
echo
echo "Compiling your collection classes..."
javac -g $PATHS $FILES
if [ $? -ne 0 ] ; then
    echo "You packaged classes do not compile."
		rm -rf $BIN
    exit -1
fi
echo "  -- OK compilation"
echo

#----------------------------------------------------------------------
# Running our tests to make sure the compiled collections run
#----------------------------------------------------------------------
echo "Testing your collection classes..."

java -cp $BIN:tests.jar edu.polytech.oop.collections.MultiListTest
if [ $? -ne 0 ] ; then
    echo "Our tests on your ArrayList and LinkedList fail."
    exit -1
fi
echo "  -- OK tests on lists"
echo

java -cp $BIN:tests.jar edu.polytech.oop.collections.MapTest
if [ $? -ne 0 ] ; then
    echo "Our tests on your HashTable fail."
    exit -1
fi
echo "  -- OK tests on maps"
echo

#----------------------------------------------------------------------
# Let's create the archive
#   - adding sources
#   - adding class files
#----------------------------------------------------------------------
echo "Creating JAR..."

jar -cf $JAR -C $SRC .
if [ $? -ne 0 ] ; then
		echo "The Java Archive creation failed, adding sources."
		rm -f $JAR
    exit -1
fi

jar -uf $JAR -C $BIN .
if [ $? -ne 0 ] ; then
		echo "Could not add the class files to the Java ARchive."
		rm -f $JAR
    exit -1
fi

#----------------------------------------------------------------------
# A bit house-cleaning...
#----------------------------------------------------------------------
rm -rf $BIN

echo "  -- OK"
echo
echo "Created edu-polytech-oop-collections.jar"
echo
exit 0
