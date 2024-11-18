import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import App from './App.jsx'; // Ensure App is correctly implemented.
import Registration from './components/auth/Registration.jsx';
import GetAdultMembers from './components/auth/GetAdultMembers.jsx';
import MemberDashboard from './components/dashboards/MemberDashboard.jsx';
import Login from './components/auth/Login.jsx';
import DirectorDashboard from './components/dashboards/DirectorDashboard.jsx';
import CommitteeDashboard from './components/dashboards/CommitteeDashboard.jsx';

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />, // Use App as the main component for the root path.
  },
  {
    path: "/registration",
    element: <Registration />,
  },
  {
    path: "/adult-members",
    element: <GetAdultMembers />,
  },
  {
    path: "/member-dashboard",
    element: <MemberDashboard />,
  },
  {
    path: "/director-dashboard",
    element: <DirectorDashboard />,
  },
  {
    path: "/committee-dashboard",
    element: <CommitteeDashboard />,
  },
  {
    path: "/member-login",
    element: <Login />,
  },
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>
);
