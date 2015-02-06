class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/api/v1/user"(controller:"user",action:"add",method:"post")
		"/api/v1/posts"(controller:"user",action:"createPost",method:"post")
		"/api/v1/labels"(controller:"user",action:"removeLabels",method:"delete")
		"/api/v1/comment/${postId}"(controller:"user",action:"addComment",method:"post")
		"/api/v1/posts/${postId}"(controller:"user",action:"updatePost",method:"put")
		"/api/v1/admins"(controller:"user",action:"findAdmin",method:"get")
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
