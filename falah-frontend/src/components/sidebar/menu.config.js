import {
    ViewListIcon,
    ChatAlt2Icon,
    BadgeCheckIcon, 
    InformationCircleIcon
  } from '@heroicons/react/outline';
  

  export const sideMenu = [
    {
      label: 'Annonces',
      Icon: ViewListIcon,
      to: '/advert',
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
];