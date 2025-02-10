<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="Dashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

</head>
<body>

    <div class="container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <h2>Engineering Hub</h2>
            <nav>
                <ul>
    <li class="active"><i class="fa-solid fa-chart-line"></i> Dashboard</li>
    <li><i class="fa-solid fa-users"></i> Team</li>
    <li><i class="fa-solid fa-file-lines"></i> Projects</li>
    <li><i class="fa-solid fa-gear"></i> Settings</li>
</ul>

            </nav>
        </aside>

        <!-- Main Content -->
        <main class="main-content">
            <div class="top-bar">
                <input type="text" class="search-bar" placeholder="Search...">
                <div class="profile">
                    <img src="https://via.placeholder.com/40" alt="Profile">
                </div>
            </div>

            <div class="content">
                <h1>Education</h1>
                
                <!-- Main Box Sections -->
                <div class="grid-container">
                    <div class="box" id="add-skill">
                        <h3>Add Skill</h3>
                        <p>Enhance your abilities by learning new skills.</p>
                        <button onclick="showMessage('Skill Added!')">Add Skill</button>
                    </div>
                    <div class="box" id="find-college">
                        <h3>Find College</h3>
                        <p>Discover the best colleges for your career path.</p>
                        <button onclick="showMessage('Searching Colleges...')">Search</button>
                    </div>
                    <div class="box" id="career-path">
                        <h3>Career Path</h3>
                        <p>Get guidance on choosing the right career.</p>
                        <button onclick="showMessage('Career Path Generated!')">Explore</button>
                    </div>
                </div>

                <!-- Additional Sections -->
                <div class="grid-container">
                    <div class="box" id="upcoming-events">
                        <h3>Upcoming Events</h3>
                        <p>Stay updated with upcoming webinars and events.</p>
                    </div>
                    <div class="box" id="latest-news">
                        <h3>Latest News</h3>
                        <p>Read about the latest trends in education and technology.</p>
                    </div>
                </div>
            </div>
        </main>
    </div>

    <script src="Dashboard.js"></script>

</body>
</html>
