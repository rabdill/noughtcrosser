<header>
    <h1>
        <g:link controller="home">Noughtcrosser</g:link>
        <em>Online tic-tac-toe</em>
    </h1>

    <p>
        <sec:ifLoggedIn>
            <sec:loggedInUserInfo field="username" />
        </sec:ifLoggedIn>

        <sec:ifNotLoggedIn>
            <g:link controller='login' action='auth'>Login</g:link>
        </sec:ifNotLoggedIn>
    </p>

</header>
