//从远程的origin仓库的master分支下载代码到本地的origin master
git fetch origin master 


git add .
git commit -m 'first commit'

//推送本地代码到远程
git push -u origin master 

/远程只有一个分支时 简写
git push