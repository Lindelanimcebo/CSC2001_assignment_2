import os
import subprocess
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import random

def main ( app ):

    df = pd.DataFrame()
    
    index = pd.MultiIndex.from_arrays([['insert' for i in range(0,3)]+['find' for i in range(0,3)], ['best_case', 'average_case', 'worst_case']*2])
    df_stats = pd.DataFrame(columns = index)
    
    for i in range(start, stop+1, step):
    
        file_name = './data/test_n_'+str(i)+'.txt'
        file = open( file_name , 'r' );
                
        data_dict = { "insert" : [] , "find" : [] } 
        
        for line in file:

            command = 'java -cp bin '+app+' '+stage(line)+' '+day(line)+' '+time(line)+' '+file_name+' > ./logs/logs.txt'
            #cmd = command.split()
            print(command)
            os.system(command)
            
            with open('./logs/logs.txt', 'r') as output:
                output_to_dict(data_dict, [line.strip() for line in output.readlines()])
        
        with open('./logs/insert_log.txt', 'r') as insert_log:
            for j in insert_log.readlines():
                data_dict['insert'].append( int(j) ) 
        
        index = pd.MultiIndex.from_arrays([ [i,i], ['insert', 'find'] ])
        
        df_n = pd.DataFrame(data=np.array([data_dict['insert'], data_dict['find']]).T , columns=index)
        
        #df_stats.loc[i] = [df_n[i]['insert'].min() ,df_n[i]['insert'].sum()/i , df_n[i]['insert'].max(), df_n[i]['find'].min(), df_n[i]['find'].sum()/i, df_n[i]['find'].max()]
        df_stats.loc[i] = [df_n[i]['insert'].min() ,df_n[i]['insert'].sum()/int(i) , df_n[i]['insert'].max(), df_n[i]['find'].min(), df_n[i]['find'].sum()/int(i), df_n[i]['find'].max()]
        df = pd.concat([df, df_n], axis=1, sort=False)
            
    with open('./logs/test_'+app+'_raw_data.csv', 'w') as out:
        df.to_csv(out)
        out.close()       
            
    with open('./logs/test_'+app+'_statistics.csv', 'w') as stats:
        df_stats.to_csv(stats)
        stats.close()
   
    axes = df_stats.plot.line()
    plt.savefig('./logs/'+app+'_graphs.png')
    plt.show()
        
def output_to_dict( dict, output):
    comparison = int( output[2].split('\t')[1] )
    dict['find'].append(comparison)       
    
def stage(line):
    return line[0]

def day(line):
    return line[2 : line.rindex('_')]

def time(line):
    rindex = line.rindex('_')
    return line[ rindex + 1 : rindex+3]

def generate (start, stop, step):
    f_data = open("./data/data.txt", 'r')
    data = f_data.readlines()

    for n in range(start, stop+1, step):
    
        f_n = open("./data/test"+"_n_"+str(n)+".txt", 'w')
        indeces = random.sample(range(2976), n)
        
        for index in indeces:
            f_n.write(data[index])
        
        f_n.close()    
    
    f_data.close()  

if __name__ == "__main__":

    usrInput = input("Press Enter for default test \nManual testing enter {start} {stop} {step}\nThe input must be space seperated eg: 2 19 16\n input >")
    
    start = 297
    stop = 2976
    step = 296
    
    if len(usrInput) > 1:
        lst = usrInput.strip().split(" ")
        start = int(lst[0])
        stop = int(lst[1])
        step = int(lst[2])

    generate(start, stop, step)
    main('LSBSTApp')
    main('LSAVLTApp')