# GitHub Users Wall On README

## 预览 Preview

![QQ图片20191026000823.png](https://pic.stackoverflow.wiki/uploadImages/62b3ac48-35b6-46c8-81d6-fb0ed4da9734.png)

## 使用方法 Usage

Clone本项目，提取`release`目录下的`GitHubUsersWallOnREADME.jar`，使用下方命令运行：
Clone the project, extract `GitHubUsersWallOnREADME.jar` from the `release` directory and run it with the following command:

```
java -jar GitHubUsersWallOnREADME
```

程序刚开始运行会询问列数，到达列数后会自动换行。
由于GitHub API接口的限制，一小时内只能生成`60`个用户。
你可以将生成后的Markdown，直接复制到你的`README.md`当中：

When the program starts running, it will query the number of columns. When the number of columns is reached, it will automatically wrap.
Due to the limitations of the GitHub API interface, only `60` users can be generated in an hour.
You can copy the generated Markdown directly into your `README.md`:

![QQ图片20191026001426.png](https://pic.stackoverflow.wiki/uploadImages/0526408e-bf1f-41b8-a588-22731567929f.png)