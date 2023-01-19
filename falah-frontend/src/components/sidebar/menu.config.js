import {
    ViewListIcon,
    ChatAlt2Icon,
    BadgeCheckIcon, 
    InformationCircleIcon,LogoutIcon
  } from '@heroicons/react/outline';
  
 
  export const sideMenu = [
    {
      label: 'Annonces',
      Icon: ViewListIcon,
      to: '/',
   
    },
    {
      label: 'Forum',
      Icon: ChatAlt2Icon,
      to: '/forum',
    },

    {
        label: 'Experts',
        Icon: BadgeCheckIcon,
        to: '/expert'
},
{
    label: 'Nouveautés',
    Icon: InformationCircleIcon ,
    to: '/nouveautes'
},
{
  label: 'Log out',
  Icon: LogoutIcon ,
  to: '/Logout'
},
];