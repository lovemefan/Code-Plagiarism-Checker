#!/usr/bin/env python
# encoding: utf-8
import os.path
import re
import tarfile
import zipfile

import rarfile
import unrar


def listDir(rootDir):
    for filename in os.listdir(rootDir):
        pathname = os.path.join(rootDir, filename)
        if (os.path.isfile(pathname)):
            # 如果是压缩文件就解压
            if (pathname.find('.zip') != -1):
                print('正在解压...  %s' % pathname)
                z = zipfile.ZipFile(pathname, 'r')
                z.extractall(path=pathname.replace('.zip', ''))
                z.close()
                print('%s  \n解压成功' % pathname)
                # unzip(pathname,pathname.replace('.zip', ''))
                # 解压完后删除文件
                # os.remove(pathname)
                print('%s删除成功' % pathname)
            if (pathname.find('.rar') != -1):
                print('正在解压%s'%pathname)
                un_rar(pathname)
                print('%s解压成功' % pathname)
                # 解压完后删除文件
                # os.remove(pathname)
                print('%s删除成功'%pathname)
            print(pathname)
        else:
            listDir(pathname)


#解压rar压缩包

def un_rar(filename):

        rar=rarfile.RarFile(filename)

        #判断同名文件夹是否存在，若不存在则创建同名文件夹
        if os.path.isdir(os.path.splitext(filename)[0]):
                pass
        else:
                os.mkdir(os.path.splitext(filename)[0])

        rar.extractall(os.path.splitext(filename)[0])


#解压缩zip压缩包

def un_zip(filename):

        zip_file=zipfile.ZipFile(filename)

        #判断同名文件夹是否存在，若不存在则创建同名文件夹
        if os.path.isdir(os.path.splitext(filename)[0]):
                pass
        else:
                os.mkdir(os.path.splitext(filename)[0])
        for names in zip_file.namelist():
                zip_file.extract(names,os.path.splitext(filename)[0])

        zip_file.close()




if __name__ == '__main__':
    root ='../data'
    listDir(root)