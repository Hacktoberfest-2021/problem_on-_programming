# -*- coding: utf-8 -*-
"""
Created on Thu Oct  7 09:42:38 2021

@author: VISHAKHA V
"""

def max_subarray_product(arr):
    n=len(arr)
    
    res=arr[0]
    
    for i in range(n):
        m=arr[i]
        
        for j in range(i+1,n):
            res=max(m,res)
            m = m * arr[j]
        res=max(res,m)
        
    return res

arr=list(map(int,input().split()))

result=max_subarray_product(arr)

print("The maximum sub_array product =",result) 
#Take the  input as [6,-3,-10,0,2] if you want, then the output will be 180
