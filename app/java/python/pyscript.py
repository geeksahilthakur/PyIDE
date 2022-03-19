
import sys
from os.path import dirname, join
from com.chaquo.python import Python


def main(CodeAreaData):
    file_dir = str(Python.getPlatform().getApplication().getFilesDir())
    filename = join(dirname(file_dir), 'file.txt')

    try:
        original_stdout = sys.stdout
        sys.stdout = open(filename, 'w', encoding = 'utf8', errors="ignore")
        exec(CodeAreaData) # it will execute our code and save output in file

        #example =>     exec("""print("hello")""")    output =>   hello --will we write in the file

        #now close the file after writing data

        sys.stdout.close()

        #reset the standard output to its original value

        sys.stdout = original_stdout

        #open file and read output and save in variable
        output = open(filename, 'r').read()



    except Exception as e:

        #to handle error
        #if any error occur in the code like syntax error then take that error message
        #in output variable to show on screen

        sys.stdout = original_stdout

        #take exception error in output

        output = e

    #finally return output
    return str(output)
